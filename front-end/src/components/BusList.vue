<template>
    <main id="busLists">
        <BusItem v-for="busItem in busItems" :key="busItem" :busItem = "busItem"></BusItem>
    </main>
</template>

<style>

</style>

<script>
import BusItem from './BusItem.vue';

export default {
  name: 'BusList',
  components: {
    BusItem,
  },
  props: {
    busItems: Array,
  },
}
</script>