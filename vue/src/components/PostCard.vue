<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.17/vue.js"></script>
<template>
    <div id="main">
        <div class="card">
            <h1 id="post-title">{{ post.postId }}</h1>
            <div class="image-container">
                <img v-if="imageUrl" :src="imageUrl" alt="Image" @click="nextPost()" />
            </div>
            <div class="post-content">
                <h2 id="post-author">{{ post.username }}</h2>
                <p id="description">{{ post.caption }}</p>
            </div>
            <!-- When ready to add Thanks or No Thanks, the syntax will be the same:
                $store.state.posts[0].likeCount
                $store.state.posts[0].dislikeCount
                $store.state.posts[0].vibeCount
                $store.state.posts[0].dateTime

                The display can be changed by the index number (0 here) to determine which post data is being
                retrieved. Our scroll mechanism will modify that index. That same index will be used to determine
                the postId to send to our URL generator for image generator.
             -->
            <div class="button-container">
                <div class="button-vibes">
                    <div class="button-style" @click="setVibes()" v-show="!vibeCheck"><i class="fa-solid fa-hand-holding-heart" style="color: #57614b;"></i></div>
                    <div class="button-style" @click="setVibes()" v-show="vibeCheck"><i class="fa-solid fa-hand-holding-heart" style="color: #C52E1D;"></i></div>
                </div>
                <div class="button-thanks">
                    <div class="button-style" @click="setThanks()" v-show="!thanksCheck"><i class="fa-solid fa-thumbs-up" style="color: #57614b;"></i></div>
                    <div class="button-style" @click="setThanks()" v-show="thanksCheck"><i class="fa-solid fa-thumbs-up" style="color: #C52E1D;"></i></div>
                </div>
                <div class="button-nothanks">
                    <div class="button-style" @click="setNoThanks()" v-show="!noThanksCheck"><i class="fa-solid fa-thumbs-down" style="color: #57614b;"></i></div>
                    <div class="button-style" @click="setNoThanks()" v-show="noThanksCheck"><i class="fa-solid fa-thumbs-down" style="color: #C52E1D;"></i></div>
                </div>
                <div class="button-style" @click="toggleHidden"><i class="fa-solid fa-comment" style="color: #57614b;"></i></div>
                <div class="button-style" ><button class="fa-solid fa-ellipsis" style="color: #57614b;"></button></div>
            </div>
        </div>
        <transition name="expand">
        <div class="card comments" v-if="isHidden">
            <h1 id="comments-title">Comments</h1>
            <div class="comment" v-if="this.$store.state.posts.length > 0">
            <div class="single-comment" v-for="(comment, commentIndex) in this.$store.state.posts[0].comments" :key="commentIndex">
                <h4 class="comment-author">{{ comment.comment_id }}</h4>
                <p class="comment-text">{{ comment.comment_text }}</p>
            </div>
            </div>
        </div>
        </transition>
    </div>
</template>
  
<script>
    //import ImageService from "../services/ImageService.js"
    import axios from 'axios'
    import { ref } from 'vue'
    const count = ref(0)

 //actions
    function postIndex(i) {
        count.value = i
    }
    
    export default {
        name: 'post-card',
        data() {
            return {
                isHidden: false,
                vibeCheck: false,
                thanksCheck: false,
                noThanksCheck: false,
                imageUrl: '',
                
            };
        },
        computed: {
            post() {
<<<<<<< HEAD
                return this.$store.state.posts.length > 0 ? this.$store.state.posts[0] : {}
=======
                return this.$store.state.posts.length > 0 ? this.$store.state.posts[count.value] : {}
>>>>>>> 2d95da21aac6a3fc1b0cb804714887824a502784
            },
        },
        methods: {
            nextPost() {
                const i= ++count.value%this.$store.state.posts.length;
                console.log(i);
                postIndex(i);
                const imgId = this.post.img_id;
                        this.fetchImage(imgId);
            },
            fetchPosts() {
                axios.get('http://localhost:9000/posts')
                .then(response => {
                    this.$store.commit('setPosts', response.data);
                    if (response.data.length > 0) {
                        
                        // this.post = response.data[0];
                        const imgId = this.post.img_id;
                        this.fetchImage(imgId);
                    }
                    
            })
            .catch(error => {
                console.error('Error fetching posts:', error);
            });
            },
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
            },
            fetchImage(imageId) {
                axios.get(`http://localhost:9000/images/${imageId}`).then(response => {
                    this.imageUrl = `data:image/jpg;base64,${response.data.imageData}`;
            })
            .catch(error => {
                console.error('Image could not be retrieved:', error);
        });
},
        },
        created() {
        
                this.fetchPosts();
               
        }
    }

</script>
  
<style>
    @import url('https://fonts.googleapis.com/css2?family=Courgette&family=Lobster&display=swap');

    html {
    overflow-y: scroll;
    }
    
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
        height: 600px;
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
        box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
    }

    #post-title {
        font-family: 'Courgette';
        font-size: 2rem;
        color: #365016;
        margin: 20px;
        text-shadow: 0px 0px 1px black;
    }

    #post-author {
        font-family: 'Courgette';
        font-size: 1.5rem;
        color: #365016;
        margin: 20px;
        text-shadow: 0px 0px 1px black;
    }

    #description {
        font-family: 'Courgette';
        font-size: 1rem;
        color: #365016;
        margin: 20px;
    }

    .image-container {
        display: flex;
        justify-content: center;
        align-items: center;
        margin: 10px auto; /* Adjust margin as needed */
    }
    img {
        max-width: 100%;
        max-height: 300px; /* Adjust height as needed */
        object-fit: contain; /* or "cover" depending on design */
    }

    .button-container {
        display: flex;
        justify-content: space-evenly;
        font-size: 2.0rem;
    }

    .button-style {
        height: 50px;
        width: 50px;
        display: flex;
        justify-content: center;
        align-items: center;
        border: 1px solid #365016;
        border-radius: 15px;
        box-shadow: rgba(54, 80, 22, 0.17) 0px -23px 25px 0px inset, rgba(54, 80, 22, 0.15) 0px -36px 30px 0px inset, rgba(54, 80, 22, 0.1) 0px -79px 40px 0px inset, rgba(54, 80, 22, 0.06) 0px 2px 1px, rgba(54, 80, 22, 0.09) 0px 4px 2px, rgba(54, 80, 22, 0.09) 0px 8px 4px, rgba(54, 80, 22, 0.09) 0px 16px 8px, rgba(54, 80, 22, 0.09) 0px 32px 16px;
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
        transition: opacity 0.5s;
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

    .expand-enter-active, .expand-leave-active {
        transition: max-height .5s ease;
        max-height: 400px;
    }

    .expand-enter, .expand-leave-to {
        max-height: 0;
        overflow: hidden;
    }

</style>