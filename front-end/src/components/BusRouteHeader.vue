<template>
    <nav class="sticky">
        <div :class="getIconClass()">
            <h1>{{ result.routeName }}</h1>
        </div>
    </nav>

    <section class="sticky">
        <div id="direction-btn-box">
            <button style="background-color: rgba(12, 71, 157);" @click="scrollToBlueRouteLine()">{{ result.endStationName
            }}
                방면</button>
            <button style="background-color: rgba(255, 0, 0, 0.7);" @click="scrollToRedRouteLine()">
                {{ result.startStationName }} 방면
            </button>
        </div>
    </section>
</template>
<script>
import axios from 'axios';

export default {
    name: 'BusRouteStickyHeader',
    props: {
        id: String,
    },
    data() {
        return {
            result: {},
        }
    },

    created() {
        this.getRouteInformation();
    },
    methods: {
        getIconClass() {
            if (!this.result || !this.result.routeTypeName) {
                return 'busNumdiv'; // Default class if no routeTypeName is defined
            }

            const routeType = this.result.routeTypeName;
            let iconClass = 'busNumdiv';

            if (routeType.includes('시외')) {
                iconClass += ' purple-text';
            } else if (routeType.includes('공항')) {
                iconClass += ' grey-text';
            } else if (routeType === '일반형시내버스') {
                iconClass += ' green-text';
            } else if (routeType === '직행좌석형시내버스') {
                iconClass += ' red-text';
            } else if (routeType === '마을버스') {
                iconClass += ' yellow-text';
            } else if (routeType === '좌석형시내버스') {
                iconClass += ' skyblue-text';
            }

            return iconClass;
        },



        scrollToBlueRouteLine() {
            const blueRouteLine = document.querySelector('.routeLine.blue');
            const firstStation = blueRouteLine.closest('li');

            if (firstStation) {
                const offset = firstStation.getBoundingClientRect().top;
                window.scrollTo({
                    top: window.scrollY + offset - 300,
                    behavior: 'smooth'
                });
            }


        },

        scrollToRedRouteLine() {
            const blueRouteLine = document.querySelector('.routeLine.red');
            const firstStation = blueRouteLine.closest('li');

            if (firstStation) {
                const offset = firstStation.getBoundingClientRect().top;
                window.scrollTo({
                    top: window.scrollY + offset - 250,
                    behavior: 'smooth'
                });
            }
        },

        async getRouteInformation() {
            try {
                const response = await axios.get("http://localhost:1005/api/routeInformation/" + this.id); // API 엔드포인트에 맞게 URL을 변경하세요
                this.result = response.data.msgBody.busRouteInfoItem;
            } catch (error) {
                console.error(error);
            }
        },
    }
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


.busNumdiv {
    background-color: rgb(253, 253, 253);
    width: 100%;
    height: 80px;
    background-color: lightgrey;
    text-align: center;
    line-height: 80px;
    font-family: 'Jeju Gothic', sans-serif;
}

#direction-btn-box {
    background-color: rgb(253, 253, 253);
    display: flex;
    /* Added to enable flex layout */
    width: 100%;
    height: 70px;
    text-align: center;
    line-height: 70px;
    border-bottom: 1px solid rgb(242, 242, 242);
}

#direction-btn-box button {
    flex: 1;
    margin: 5px;
    border-radius: 5px;
    border: none;
    font-size: 18px;
    color: white;
    font-family: 'Jeju Gothic', sans-serif;
}

.sticky {
    position: sticky;
    top: 0;
    z-index: 700;
    background-color: white;
    position: -webkit-sticky;
}
</style>
