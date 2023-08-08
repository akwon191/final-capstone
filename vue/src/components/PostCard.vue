<template>
    <div class="card" >
        <h1 class="post-title">Example Title</h1>
<!--      <img v-if="" v-bind:src="" /> Image Goes Here-->
        <h2 class="post-author">Author Name</h2>
        <p class="description">This is an example of how the description box will look. This text will be deleted later and linked to the description from the post.</p>
        <div class="button-container">
            <div class="button-vibes" v-if="! vibeCheck">
                <i class="fa-solid fa-hand-holding-heart" v-on:click.prevent="setVibes(true)" >Good Vibes</i>
               <!-- <i class="fa-solid fa-hand-holding-heart" v-on:click.prevent="setVibes(false)" >Remove Vibes</i> -->
            </div>
            <div class="button-thanks" v-if="! thanksCheck">
                <i class="fa-solid fa-thumbs-up" v-on:click.prevent="setThanks(true)" >Thanks</i>
               <!-- <i class="fa-solid fa-thumbs-up" v-on:click.prevent="setThanks(false)" >Remove No Thanks</i> -->
            </div>
            <div class="button-nothanks" v-if="! thanksCheck">
                <i class="fa-solid fa-thumbs-down" v-on:click.prevent="setNoThanks(true)" >No Thanks</i>
               <!-- <i class="fa-solid fa-thumbs-down" v-on:click.prevent="setThanks(false)" >Remove No Thanks</i> -->
            </div>
            <i class="fa-solid fa-comment" >Comments</i>
            <i class="fa-solid fa-ellipsis" >Extra</i>
        </div>
    </div>
  </template>
  
  <script>
  export default {
      name: 'post-card',
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

    .card {
        position: relative;
        background: whitesmoke;
        border: 10px solid #FF9B42;
        border-radius: 10px;
        width: 500px;
        height: 500px;
        margin: 20px;
    }
    .card:after {
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

    .card:before {
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

    .post-title {
        font-family: 'Courgette';
        font-size: 2rem;
        color: #365016;
        margin: 20px;
    }

    .post-author {
        font-family: 'Courgette';
        font-size: 1.5rem;
        color: #365016;
        margin: 20px;
    }

    .description {
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

  </style>