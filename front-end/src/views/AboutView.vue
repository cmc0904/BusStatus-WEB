<template>
  <div class="sticky">
    <TitleHeader :title="'실시간 버스 현황'"></TitleHeader>
    <BusRouteHeader :id="this.id"></BusRouteHeader>
  </div>
  <BusRouteMain :id="this.id"></BusRouteMain>
  <BusRouteBottomNav :id="this.id"></BusRouteBottomNav>
</template>


<script>
import TitleHeader from '@/components/TitleHeader.vue';
import BusRouteHeader from '@/components/BusRouteHeader.vue';
import BusRouteMain from '@/components/BusRouteMain.vue';
import BusRouteBottomNav from '@/components/BusRouteBottomNav.vue';

export default {
  name: 'aboutView',
  props: ['id'],  // 라우터에서 받은 정보를 props로 사용

  components: {
    TitleHeader,
    BusRouteHeader,
    BusRouteMain,
    BusRouteBottomNav
},

  methods: {
    goBack() {
      this.$router.go(-1) // 한 단계 뒤로
    },
  }
};
</script>

