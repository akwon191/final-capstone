<template>
    <div class="card" >
        <h1 class="post-title">Example Title</h1>
<!--      <img v-if="" v-bind:src="" /> Image Goes Here-->
        <h2 class="post-author">Author Name</h2>
        <p class="description">This is an example of how the description box will look. This text will be deleted later and linked to the description from the post.</p>
        <div class="button-container">
            <div class="button-vibes" v-if="! vibeCheck">
                <button class="mark-vibeson" v-on:click.prevent="setVibes(true)" >Good Vibes</button>
               <!-- <button class="mark-vibesoff" v-on:click.prevent="setVibes(false)" >Remove Vibes</button> -->
            </div>
            <div class="button-thanks" v-if="! thanksCheck">
                <button class="mark-thankson" v-on:click.prevent="setThanks(true)" >No Thanks</button>
               <!-- <button class="mark-thanksoff" v-on:click.prevent="setThanks(false)" >Remove No Thanks</button> -->
            </div>
            <button class="button-comments" >Comments</button>
            <button class="button-extra" >Extra</button>
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
      }
  }
  </script>
  
  <style>
    .card {
        position: relative;
        background: white;
        border: 10px solid #FD8A8A;
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
        background: #FFFBC1;
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
        background: #B6E2A1;
        z-index: -2;
    }

    .card .post-title {
        font-size: 2rem;
        color: #FD8A8A;
        margin: 20px;
    }

    .card .post-author {
        font-size: 1.5rem;
        color: #FD8A8A;
        margin: 20px;
    }

    .card .description {
        font-size: 1rem;
        color: #FD8A8A;
        margin: 20px;
    }

    .button-container {
        display: flex;
        justify-content: space-evenly;
    }

  </style>