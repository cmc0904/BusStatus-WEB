<template>
    <footer>
        <div class="direction-btn-box">

            <router-link :to="{ name: 'home'}" class="item">
                <div class="nav-item">
                    검색하기
                </div>
            </router-link>

            <router-link :to="{ name: 'startPage'}" class="item">
                <div class="nav-item">
                    즐겨찾기
                </div>
            </router-link>

        </div>
    </footer>
</template>

<style scoped>

.direction-btn-box {
    background-color: rgb(12, 71, 157);
    display: flex;
    /* Added to enable flex layout */
    width: 100%;
    height: 40px;
    text-align: center;
    line-height: 40px;
    bottom: 0;
    position: fixed;
}

.direction-btn-box .item {
    flex: 1;
    font-family: 'Jeju Gothic', sans-serif;
    margin: 5px;
    border-radius: 5px;
    border: none;
    font-size: 18px;
    color: white;
    text-decoration: none;
}
</style>
