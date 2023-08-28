<template>
    <div class="bottom-nav">
        <a @click="goBack()">
            <div class="nav-item">
                <i class="fa-solid fa-arrow-left"></i>
            </div>
        </a>

        <a @click="follow()" style="float: right;">
            <div class="nav-item">
                <i v-if="result" class="fa-solid fa-star yellow-text"></i>
                <i v-if="!result" class="fa-solid fa-star white-text"></i>
            </div>
        </a>
    </div>
</template>

<script>
import axios from 'axios';


export default {
    name: 'BusRouteFooter',
    props: ['id'],
    data() {
        return {
            result: false,
        }
    },
    created() {
        this.getIcon();
    },
    methods: {
        goBack() {
            this.$router.go(-1) // 한 단계 뒤로
        },

        async follow() {
            try {
                var res = await axios.get("http://localhost:1005/api/chFavoriteIte/" + this.id);

                console.log(res.data)

                if(res.data) {
                    await axios.post("http://localhost:1005/api/follow/" + this.id); 
                } else {
                    await axios.post("http://localhost:1005/api/unfollow/" + this.id); 
                }

                this.getIcon()
            } catch (error) {
                console.error(error);
            }
        },

        async getIcon() {
            try {
                
                var res = await axios.get("http://localhost:1005/api/chFavoriteIte/" + this.id);

                console.log(res.data)

                if(res.data) {
                    this.result = false;
                } else {
                    this.result = true;
                }
                

            } catch (error) {
                console.error(error);
            }
        },
    }
};
</script>

<style scoped>
.bottom-nav {
    position: fixed;
    bottom: 0;
    left: 0;
    width: 100%;
    height: 56px;
    background-color: rgb(12, 71, 157);
    display: flex;
    align-items: center;
    z-index: 700;
    justify-content: space-between;
}

.nav-item {
    padding-left: 15px;
    font-size: 25px;
    color: white;
    padding-right: 15px;
}

.yellow-text {
    color: yellow;
}

.white-text {
    color: white;
}
</style>
