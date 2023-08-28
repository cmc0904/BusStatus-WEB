<template>
    <div class="bus busRoute">
        <ul>
            <!--
            <li> <a href="#">
                    <div class="brLine"> </div>
                    <div class="busDescT"> </div>
                </a>
            </li>-->
            <div style="height: 30px;">

            </div>

            <li v-for="(station, index) in result" :key="station.stationId">
                <a href="#">
                    <div class="brLine">
                        <span v-if = "result.length - (index+1) != 0" :class="busTypeClass(station)"></span>
                        <span class="bus-station"></span> <span v-if="locations.includes(station.stationId)"
                            class="bus-icon"></span>
                    </div>
                    <div class="busDescT "> <strong>{{ station.stationName }}</strong> <span>{{ station.mobileNo ==
                        undefined ? '미정차' : station.mobileNo
                    }} | {{ station.regionName }}</span> </div>
                </a>
            </li>

            <li>
                <a href="#">
                    <div class="brLine"> </div>
                    <div class="busDescT"> </div>
                </a>
            </li>

        </ul>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'BusRouteMain',
    props: {
        id: String,
    },
    data() {
        return {
            result: [],
            locations: [],
        };
    },
    created() {
        this.getBusStations();
        this.getBusLocation();

        // setInterval(this.getBusLocation, 30000);
    },
    computed: {
        busTypeClass() {
            return (station) => ({
                routeLine: true,
                blue: station.direction === 'DOWN',
                red: station.direction === 'UP',
            });
        },
    },
    methods: {
        async getBusStations() {
            try {
                const response = await axios.get(`http://localhost:1005/api/routeStations/${this.id}`);
                const data = response.data.msgBody.busRouteStationList;

                let turnYnFound = false;

                data.forEach((item) => {
                    item.direction = turnYnFound ? 'UP' : 'DOWN';
                    if (!turnYnFound && item.turnYn === 'Y') {
                        turnYnFound = true;
                    }
                });

                this.result = data;
            } catch (error) {
                console.error(error);
            }
        },
        async getBusLocation() {
            try {
                const response = await axios.get(`http://localhost:1005/api/busLocation/${this.id}`);
                this.locations = response.data.msgBody.busLocationList.map((item) => item.stationId);
                console.log(this.locations)
            } catch (error) {
                console.error(error);
            }
        },
    },
};

</script>

<style scoped>
.bus-icon {
    width: 35px;
    height: 40px;
    margin-right: 10px;
    background-image: url("https://cdn.discordapp.com/attachments/1117595467442827264/1140472724444160073/icons8-bus-64_1.png");
    background-repeat: no-repeat;
    background-size: contain;
    position: absolute;
    left: 41px;
    z-index: 10;
    /*top: 18px;*/
    bottom: 25px; /* 정류소 아이콘에 버스 바로 위 */
}

.blue {
    background-color: #0d47a1;
}

.red {
    background-color: #fe4d4f;
}

ul {
    list-style: none;
    font-family: NanumSquareNeo-Variable;
}

a {
    color: #000;
    text-decoration: none;
}

.bus {
    overflow: hidden;
    background: #fff;
}

.bus li a {
    display: block;
    height: 56px;
    width: 100%;
}

.bus li.busTurn {
    height: 33px;
}

.bus li.busTurn .busDescT {
    height: 100%;
    width: 250px;
    background: #848c94;
    border-radius: 12px;
    border-top: 0;
    left: 45px;
    font-weight: bolder;
}

.bus li.busTurn .brLine:after {
    content: '';
    display: block;
    position: absolute;
    top: 0;
    right: 0;
    width: 15px;
    height: 100%;
    background: #eaeaee;
}

.bus li.busTurn .busTurnText {
    background: none;
    font-size: 15px;
    color: white;
    padding-left: 30px;
    line-height: 33px;
}

.bus li:first-child .brLine {
    height: 38px;
    margin: 18px 0 0;
}

.bus li:last-child .brLine {
    height: 19px;
}

.bus li:first-child .bus-station {
    top: 0;
}

.bus .brLine {
    float: left;
    position: relative;
    width: 80px;
    height: 100%;
}

.bus .busDescT {
    overflow: hidden;
    position: relative;
    height: 55px;
    padding: 0 5px;
    white-space: nowrap;
    line-height: 17px;
    font-family: 'Jeju Gothic', sans-serif;
    bottom: 20px; /* 아이콘 옆 버스 정류소 이름을 나오게 하기 위한 코드임.*/
}

.busDescT strong {
    display: block;
    overflow: hidden;
    margin-top: 12px;
    font-size: 15px;
    font-weight: 700;
    font-weight: normal;
    color: #000;
    white-space: nowrap;
    text-overflow: ellipsis;
}

.busDescT span {
    display: block;
    font-size: 13px;
    color: #979899;
    font-family: Helvetica-Light, sans-seirf;
}

.bus-station {
    width: 20px;
    height: 39px;
    margin-right: 10px;
    background-image: url("https://cdn.discordapp.com/attachments/1076715123089088563/1078880179142791358/icons8-down-arrow-64.png");
    background-repeat: no-repeat;
    background-size: contain;
    position: absolute;
    left: 48px;
    z-index: 10;
    top: -6px;
}

.routeLine {
    overflow: hidden;
    position: absolute;
    top: 0;
    bottom: 0;
    right: 15px;
    z-index: 1;
    width: 15px;
}

@media (max-width: 991px) {
    .button {
        border: none;
        color: white;
        padding: 15px;
        text-align: center;
        text-decoration: none;
        display: inline-block;
        font-size: 16px;
        margin: 4px 2px;
        cursor: pointer;
        font-size: 32px;
        border-radius: 6px;
        font-family: NanumSquareNeo-Variable;
    }

    .bus li.busTurn .busDescT {
        left: 20px;
    }

    .text {
        font-size: 20px;
        border-right: .05em solid black;
    }
}
</style>
