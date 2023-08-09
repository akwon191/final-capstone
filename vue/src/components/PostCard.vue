<template>
    <div id="main">
        <div class="card">
            <h1 id="post-title">{{ post.title }}</h1>
            <!-- <img v-if="" v-bind:src="" /> Image Goes Here-->
            <h2 id="post-author">{{ post.author }}</h2>
            <p id="description">{{ post.caption }}</p>
            <div class="button-container">
                <div class="button-vibes">
                    <div @click="setVibes()" v-if="!vibeCheck"><i class="fa-solid fa-hand-holding-heart"></i></div>
                    <div @click="setVibes()" v-if="vibeCheck"><i class="fa-solid fa-hand-holding-heart" style="color: #C52E1D;"></i></div>
                </div>
                <div class="button-thanks">
                    <div @click="setThanks()" v-if="!thanksCheck"><i class="fa-solid fa-thumbs-up"></i></div>
                    <div @click="setThanks()" v-if="thanksCheck"><i class="fa-solid fa-thumbs-up" style="color: #C52E1D;"></i></div>
                </div>
                <div class="button-nothanks">
                    <div @click="setNoThanks()" v-if="!noThanksCheck"><i class="fa-solid fa-thumbs-down"></i></div>
                    <div @click="setNoThanks()" v-if="noThanksCheck"><i class="fa-solid fa-thumbs-down" style="color: #C52E1D;"></i></div>
                </div>
                <div @click="toggleHidden"><i class="fa-solid fa-comment" ></i></div>
                <div><button class="fa-solid fa-ellipsis" ></button></div>
            </div>
        </div>
        <div class="card comments" v-if="isHidden">
            <h1 id="comments-title">Comments</h1>
            <div class="comment">
                <h3 class="comment-author">{{ comments.author }}</h3>
                <p class="comment-text">{{ comments.caption }}</p>
            </div>
        </div>
    </div>
</template>
  
<script>
    import PostService from "../services/PostService.js"
    import ImageService from "../services/ImageService.js"

    export default {
        name: 'post-card',
        data() {
            return {
                post: {
                    id: 0,
                    userId: 0,
                    dateTime: '',
                    caption: '',
                    imgDataId: 0
                },
                isHidden: true,
                vibeCheck: false,
                thanksCheck: false,
                noThanksCheck: false,
            };
        },
        methods: {
            setVibes() {
                this.vibeCheck = !this.vibeCheck;
            },
            setThanks() {
                this.thanksCheck = !this.thanksCheck;
            },
            setNoThanks() {
                this.noThanksCheck = !this.noThanksCheck;
            },
            toggleHidden() {
                this.isHidden = !this.isHidden;
            }
        },
        created() {
            PostService.get(this.$props.id).then((response) => {
                this.post = response.data;
            });
        }
    }
</script>
  
<style>
    @import url('https://fonts.googleapis.com/css2?family=Courgette&family=Lobster&display=swap');
    
    #main {
        display: flex;
        flex-direction: column;
    }

    .card {
        margin-bottom: -20px;
        position: relative;
        background: whitesmoke;
        border-top: 10px solid #FF9B42;
        border-right: 10px solid #FF9B42;
        border-left: 10px solid #FF9B42;
        border-bottom: 10px solid #FF9B42;
        border-radius: 10px;
        width: 500px;
        height: 500px;
    }
   
    .card::after {
        content: '';
        position: absolute;
        top: -20px;
        left: -20px;
        right: -20px;
        bottom: -20px;
        border-radius: 10px;
        background: #F7A072;
        z-index: -1;
    }

    .card::before {
        content: '';
        position: absolute;
        top: -30px;
        left: -30px;
        right: -30px;
        bottom: -30px;
        border-radius: 10px;
        background: #EDDEA4;
        z-index: -2;
        box-shadow: 5px 10px #888888;
    }

    #post-title {
        font-family: 'Courgette';
        font-size: 2rem;
        color: #365016;
        margin: 20px;
    }

    #post-author {
        font-family: 'Courgette';
        font-size: 1.5rem;
        color: #365016;
        margin: 20px;
    }

    #description {
        font-family: 'Courgette';
        font-size: 1rem;
        color: #365016;
        margin: 20px;
    }

    .button-container {
        display: flex;
        justify-content: space-evenly;
        font-size: 2.0rem;
        color: #57614b;
    }

    .card.comments {
        border-top: 0px;
        border-top-left-radius: 0px;
        border-top-right-radius: 0px;
    }

    .card.comments::after {
        top: 0px;
        border-top-left-radius: 0px;
        border-top-right-radius: 0px;
    }

    .card.comments::before {
        top: 0px;
        border-top-left-radius: 0px;
        border-top-right-radius: 0px;
    }

    #comments-title {
        border-top: 5px solid #FF9B42;
        border-bottom: 5px solid #FF9B42;
        font-family: 'Courgette';
        font-size: 1.5rem;
        color: #365016;
        text-align: center;
        margin: auto;
    }

    .comment {
        border: solid 1px rgba(0, 0, 0, 0.5);
        border-radius: 10px;
        margin: 10px;
        box-sizing: border-box;
        width: auto;
        position: relative;
        clear: both;
        background: rgb(226, 226, 226);
    }

    .comment-author {
        font-family: 'Courgette';
        font-size: 1rem;
        color: #365016;
        margin: 10px;
    }

    .comment-text {
        font-family: 'Courgette';
        font-size: 0.9rem;
        color: #365016;
        margin: 10px;
    }

</style>