<template>
    <div id="main">
        <div class="card">
            <h1 id="post-title">Example Title</h1>
            <!-- <img v-if="" v-bind:src="" /> Image Goes Here-->
            <h2 id="post-author">Author Name</h2>
            <p id="description">This is an example of how the description box will look. This text will be deleted later and linked to the description from the post.</p>
            <div class="button-container">
                <div class="button-vibes" v-if="! vibeCheck">
                    <button class="fa-solid fa-hand-holding-heart" v-on:click.prevent="setVibes(true)" >Good Vibes</button>
                    <!-- <button class="fa-solid fa-hand-holding-heart" v-on:click.prevent="setVibes(false)" >Remove Vibes</button> -->
                </div>
                <div class="button-thanks" v-if="! thanksCheck">
                    <button class="fa-solid fa-thumbs-up" v-on:click.prevent="setThanks(true)" >Thanks</button>
                    <!-- <button class="fa-solid fa-thumbs-up" v-on:click.prevent="setThanks(false)" >Remove No Thanks</button> -->
                </div>
                <div class="button-nothanks" v-if="! thanksCheck">
                    <button class="fa-solid fa-thumbs-down" v-on:click.prevent="setNoThanks(true)" >No Thanks</button>
                    <!-- <button class="fa-solid fa-thumbs-down" v-on:click.prevent="setThanks(false)" >Remove No Thanks</button> -->
                </div>
                <button class="fa-solid fa-comment" v-on:click="isHidden = !isHidden">Comments</button>
                <button class="fa-solid fa-ellipsis" >Extra</button>
            </div>
        </div>
        <div class="card comments" v-if="isHidden">
            <h1 id="comments-title">Comments</h1>
            <div class="comment" >
                <h3 class="comment-author">Comment Author</h3>
                <p class="comment-text">This is an example of how the comment box will look. This text will be deleted later and linked to the comments from the post.</p>
            </div>
        </div>
    </div>
  </template>
  
  <script>
  export default {
      name: 'post-card',
      data() {
        return {
            isHidden: true
        };
    },
      props: {
        post: Object,
        vibeCheck: {
            type: Boolean,
            default: false
        },
        thanksCheck: {
            type:Boolean,
            default: false
        },
        noThanksCheck: {
            type:Boolean,
            default: false
        }
      },
      methods: {
//        setVibes(value) {
//            Method to commit changes to vibes status
//            this.$store.commit('SET_VIBES_STATUS', {post: this.post, value: value});
//        },
//        setThanks(value) {
//            Method to commit changes to no thanks status
//            this.$store.commit('SET_THANKS_STATUS', {post: this.post, value: value});
//        }
//        setNoThanks(value) {
//            Method to commit changes to no thanks status
//            this.$store.commit('SET_NOTHANKS_STATUS', {post: this.post, value: value});
//        }
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