<template>
  <header class="sticky">
    <div id="title">
      <div class="title-content">
        <div class="centered-text">{{ title }}</div>
        <div class="button-container">
        <router-link :to="{ name: 'home'}" class="nav-button">
          검색
        </router-link>
        <router-link :to="{ name: 'startPage'}" class="nav-button">
          즐겨찾기
        </router-link>
      </div>
      </div>

    </div>
  </header>
</template>

<script>
export default {
  name: 'BusItem',
  props: {
    title: String,
  },
};
</script>

<style scoped>
#title {
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: rgb(253, 253, 253);
  border-bottom: 1px solid rgb(242, 242, 242);
  color: rgb(12, 71, 157);
  font-size: 17px;
  font-weight: 700;
  height: 47px;
  padding: 0 20px;
  box-sizing: border-box;
}

.title-content {
  text-align: center;
  flex-grow: 1;
}

.centered-text {
  margin-top: 5px;
  display: inline-block;
  display: flex;
  justify-content: center;
}

.button-container {
  float: right;
  display: flex;
  gap: 25px;
}

.nav-button {
  display: inline-block;
  border: none;
  font-size: 15px;
  background-color: transparent;
  font-family: 'Jeju Gothic', sans-serif;
  color: inherit;
  text-decoration: none;
}
</style>
