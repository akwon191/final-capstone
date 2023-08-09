<template>
  <div class="home">
    <h1 id="home-text">Home</h1>
    <feed-list />
  </div>
</template>

<script>
import FeedList from '../components/FeedList.vue';

export default {
  name: "home",
  components: {
    FeedList
  }
};
</script>

<style>

    #home-text {
        font-family: 'Courgette';
        font-size: 3rem;
        color: #365016;
        text-shadow: 0px 0px 2px black;
        position: relative;
        background: whitesmoke;
        border-top: 5px solid #FF9B42;
        border-right: 5px solid #FF9B42;
        border-left: 5px solid #FF9B42;
        border-bottom: 5px solid #FF9B42;
        border-radius: 5px;
        width: fit-content;
        padding-right: 10px;
        padding-left: 100px;
        margin-left: -20px;
    }
   
    #home-text::after {
        content: '';
        position: absolute;
        top: -10px;
        left: -10px;
        right: -10px;
        bottom: -10px;
        border-radius: 10px;
        background: #F7A072;
        z-index: -1;
    }

    #home-text::before {
        content: '';
        position: absolute;
        top: -15px;
        left: -15px;
        right: -15px;
        bottom: -15px;
        border-radius: 10px;
        background: #EDDEA4;
        z-index: -2;
        box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
    }

</style>
