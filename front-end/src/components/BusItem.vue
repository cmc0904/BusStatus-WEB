<template>
    <router-link :to="{ name: 'about', params: { id: busItem.routeId }}" class="bus-list-item">
        <div class="item-container">
            <div class="item-image">
                <div>
                    <i :class="getIconClass()"></i>
                </div>
            </div>
            <div class="item-details">
                <div class="item-name">{{ busItem.routeName }}</div>
                <div class="item-city">{{ busItem.startStationName }} ~ {{ busItem.endStationName }}</div>
                <div class="item-city">첫차 : {{ busItem.downFirstTime }} | 배차 시간 : {{ busItem.peekAlloc }}</div>
                <div class="item-city">막차 : {{ busItem.downLastTime }}</div>
            </div>
        </div>
    </router-link>
</template>

<script>

export default {
    name: 'BusItem',
    props: {
        busItem: Object,
    },
    methods: {
        getIconClass() {
            const routeType = this.busItem.routeTypeName;
            if (routeType === '일반형시내버스')
                return 'fa-solid fa-bus green-text';
            if (routeType === '직행좌석형시내버스')
                return 'fa-solid fa-bus red-text';
            if (routeType === '마을버스')
                return 'fa-solid fa-bus yellow-text';
            if (routeType === '좌석형시내버스')
                return 'fa-solid fa-bus skyblue-text';
            if (routeType.indexOf('시외') !== -1)
                return 'fa-solid fa-bus purple-text';
            if (routeType.indexOf('공항') !== -1)
                return 'fa-solid fa-bus grey-text';

            return 'fa-solid fa-bus black-text'
        },
    },
}
</script>

<style scoped>
.green-text {
    color: green;
}

.red-text {
    color: red;
}

.yellow-text {
    color: #FFD400;
}

.skyblue-text {
    color: skyblue;
}

.purple-text {
    color: purple;
}

.grey-text {
    color: grey;
}

.black-text {
    color: black;
}


.bus-list-item {
    text-decoration: none;
}

.item-container {
    
    align-items: center;
    border-bottom: 1px solid #ccc;
    display: flex;
    padding: 4px;
}

.item-image {
    font-size: 50px;
    height: 100px;
    line-height: 100px;
    position: relative;
    text-align: center;
    width: 100px;
}

.busTypeText {
    bottom: -40px;
    font-size: 15px;
    position: absolute;
    width: 100%;
}

.item-details {
    flex-grow: 1;
}

.item-name {
    font-family: 'Jeju Gothic', sans-serif;
    color: black;
    font-family: 'GmarketSansMedium';
    font-size: 25px;
    font-weight: bold;
}

.item-city {
    font-family: 'Jeju Gothic', sans-serif;
    color: #666;
    font-size: 13px;
    margin-bottom: 5px;
}

.item-price {
    font-family: 'Jeju Gothic', sans-serif;
    color: #333;
    font-family: 'GmarketSansMedium';
    font-size: 17px;
    font-weight: bold;
}
</style>