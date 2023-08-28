<template>
  <div class="sticky">
    <TitleHeader :title="'검색'"></TitleHeader>
    <SearchBar @search="performSearch"></SearchBar>
  </div>
  <busLists :busItems="results"></busLists>

  <div class = "error" v-if="resultNone">일치하는 검색결과가 없습니다.</div>
</template>



<script>
import TitleHeader from '@/components/TitleHeader.vue';
import SearchBar from '@/components/SearchBar.vue';
import BusLists from '@/components/BusList.vue';
import axios from 'axios';

export default {
  name: 'HomeView',
  components: {
    TitleHeader,
    SearchBar,
    BusLists,
},
  data() {
    return {
      results: [],
      resultNone: false
    }
  },
  methods: {
    async performSearch(busNum, type) {
      try {
        const response = await axios.get("http://localhost:1005/api/busLists/" + busNum + "/" + type);
        const datas = response.data.msgBody.busRouteList;

 

        const filteredDatas = datas.filter(item => {
          if (
            type === "전체" ||
            type === item.routeTypeName ||
            (type === "시외" || type === "공항") && item.routeTypeName.includes(type)
          ) {
            return true;
          }
          return false;
        });

        const routeIds = filteredDatas.map(item => item.routeId);



        const requestPromises = routeIds.map(async routeId => {
          const response = axios.get("http://localhost:1005/api/routeInformation/" + routeId);
          return response;
        });

        const responses = await Promise.all(requestPromises);
        this.resultNone = false;
        this.results = responses.map(response => response.data.msgBody.busRouteInfoItem);
      } catch (error) {
        this.results = [];
        this.resultNone = true;
      }
    },

  },
}
</script>

<style>
.error {
  margin-top: 15px;
  font-size: 15px;
  color: rgb(160, 160, 160);
  text-align: center;
}
</style>