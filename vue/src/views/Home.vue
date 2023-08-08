<template>
  <div class="home">
    <h1>Home</h1>
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

    h1 {
        font-family: 'Courgette';
        font-size: 3rem;
        color: #365016;
        margin: 20px;
    }

</style>
