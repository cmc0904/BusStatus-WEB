<template>
  <router-view />
</template>

<style>
@import url(//fonts.googleapis.com/earlyaccess/jejugothic.css);

/* Common Styles */
body, html {
  font-family: 'Jeju Gothic', sans-serif;
}

* {
  margin: 0;
  padding: 0;

}

.sticky {
  position: sticky;
  top: 0;
  z-index: 700;
  background-color: white;
  position: -webkit-sticky;
}
</style>
