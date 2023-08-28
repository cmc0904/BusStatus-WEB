<template>
    <div class="sticky">
        <TitleHeader :title="'즐겨찾기'"></TitleHeader>
    </div>

    <BusLists :busItems="results"></BusLists>
</template>


<script>
import TitleHeader from '@/components/TitleHeader.vue';
import BusLists from '@/components/BusList.vue';
import axios from 'axios';
export default {
    name: 'HomeView',
    components: {
        TitleHeader,
        BusLists,
    },
    data() {
        return {
            results: [],
            resultNone: false
        }
    },
    created() {
        this.getAllFavoriteItem();
    },
    methods: {
        async getAllFavoriteItem() {
            try {
                var res = await axios.get("http://localhost:1005/api/getFollowList");


                const requestPromises = res.data.map(async routeId => {
                    const response = axios.get("http://localhost:1005/api/routeInformation/" + routeId);
                    return response;
                });

                const responses = await Promise.all(requestPromises);
                this.results = responses.map(response => response.data.msgBody.busRouteInfoItem);
                console.log(this.results)
            } catch (error) {
                console.error(error);
            }
        },


    }
}
</script>