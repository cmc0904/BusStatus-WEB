<template>
  <nav id="nav" class="sticky">
    <div class="search-container">
      <div class="search-input-container">
        <input v-model="busNum" type="text" class="search-input" @keyup="handleKeyUp" placeholder="노선, 정류소를 입력하세요">
        <button @click="clearInputBox();" class="search-button">
          <svg class="search-icon" focusable="false" viewBox="0 0 512 512" height="20" width="20" fill="#A0A0A0"
            secondaryopacity="0.4" size="20">
            <g height="20" width="20" fill="#A0A0A0" secondaryopacity="0.4" size="20" fill-opacity="1">
              <path
                d="M256 8C119 8 8 119 8 256s111 248 248 248 248-111 248-248S393 8 256 8zm121.6 313.1a12 12 0 0 1 0 17L338 377.6a12 12 0 0 1-17 0L256 312l-65.1 65.6a12 12 0 0 1-17 0L134.4 338a12 12 0 0 1 0-17l65.6-65-65.6-65.1a12 12 0 0 1 0-17l39.6-39.6a12 12 0 0 1 17 0l65 65.7 65.1-65.6a12 12 0 0 1 17 0l39.6 39.6a12 12 0 0 1 0 17L312 256z"
                height="20" width="20" secondaryopacity="0.4" size="20" fill-opacity="0.4"></path>
              <path
                d="M377.6 321.1a12 12 0 0 1 0 17L338 377.6a12 12 0 0 1-17 0L256 312l-65.1 65.6a12 12 0 0 1-17 0L134.4 338a12 12 0 0 1 0-17l65.6-65-65.6-65.1a12 12 0 0 1 0-17l39.6-39.6a12 12 0 0 1 17 0l65 65.7 65.1-65.6a12 12 0 0 1 17 0l39.6 39.6a12 12 0 0 1 0 17L312 256z"
                height="20" width="20" fill="#A0A0A0" secondaryopacity="0.4" size="20" fill-opacity="1"></path>
            </g>
          </svg>
        </button>
      </div>
      <button @click="postData();" class="search-button">
        <svg focusable="false" viewBox="0 0 512 512" height="26" width="26" fill="#0C479D" secondaryopacity="0.4"
          size="26">
          <g height="26" width="26" fill="#0C479D" secondaryopacity="0.4" size="26" fill-opacity="1">
            <path
              d="M208 80a128 128 0 1 1-90.51 37.49A127.15 127.15 0 0 1 208 80m0-80C93.12 0 0 93.12 0 208s93.12 208 208 208 208-93.12 208-208S322.88 0 208 0z"
              height="26" width="26" secondaryopacity="0.4" size="26" fill-opacity="0.4"></path>
            <path
              d="M504.9 476.7L476.6 505a23.9 23.9 0 0 1-33.9 0L343 405.3a24 24 0 0 1-7-17V372l36-36h16.3a24 24 0 0 1 17 7l99.7 99.7a24.11 24.11 0 0 1-.1 34z"
              height="26" width="26" fill="#0C479D" secondaryopacity="0.4" size="26" fill-opacity="1"></path>
          </g>
        </svg>
      </button>
    </div>
  </nav>


  <section id="filter" class="sticky">
    <button class="filter-btn" style="color:black;" @click="this.type = '전체'; postData();">전체</button>
    <button class="filter-btn" style="background-color: green;" @click="this.type = '일반형시내버스'; postData();">일반</button>
    <button class="filter-btn" style="background-color: red;" @click="this.type = '직행좌석형시내버스'; postData();">직좌</button>
    <button class="filter-btn" style="background-color: skyblue;" @click="this.type = '좌석형시내버스'; postData();">좌석</button>
    <button class="filter-btn" style="background-color: yellow;" @click="this.type = '마을버스'; postData();">마을</button>
    <button class="filter-btn" style="background-color: purple;" @click="this.type = '시외'; postData();">시외</button>
    <button class="filter-btn" style="background-color: grey;" @click="this.type = '공항'; postData();">공항</button>
  </section>
</template>

<script>
export default {
  emits: ['search'], 
  data() {
    return {
      busNum: "",
      type: "전체"
    }
  },

  methods: {
    handleKeyUp(event) {
      if (event.key === 'Enter') {
        this.postData();
      }
    },

    postData() {
      this.$emit("search", this.busNum, this.type);
    },

    clearInputBox() {
      this.busNum = "";
    },
  },
  // ...
}
</script>

<style scoped>
/* Navigation Styles */
#nav {
  border-bottom: 1px solid rgb(242, 242, 242);
  height: auto;
  padding-bottom: 10px;
}

.search-container {
  align-items: center;
  display: flex;
  justify-content: center;
  margin-left: 10px;
  margin-top: 10px;
  position: relative;
}

.search-input-container {
  flex: 1;
  position: relative;
}

.search-input {
  background-color: rgb(237, 237, 237);
  border: none;
  border-radius: 20px;
  font-size: 14px;
  height: 30px;
  max-width: calc(100% - 100px);
  padding: 10px 30px 10px 20px;
  font-family: 'Jeju Gothic', sans-serif;
  width: 100%;
}

.search-icon,
.search-button {
  fill: #A0A0A0;
  position: absolute;
  right: 10px;
  top: 50%;
  transform: translateY(-50%);
  z-index: 2;
}

.search-icon {
  right: 60px;
}

.search-button {
  background-color: transparent;
  border: none;
}

/* 필터링 */

/* Filter Styles */
#filter {
  border-bottom: 1px solid rgb(242, 242, 242);
  padding: 10px;
}

.filter-btn {
  background-color: transparent;
  border: none;
  border-radius: 5px;
  color: white;
  margin-right: 5px;
  padding: 8px 17px;
  font-family: 'Jeju Gothic', sans-serif;
}

.filter-btn:focus {
  border: 2px solid black;
}
</style>