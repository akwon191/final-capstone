<template>
  <div class="home">
    <h1>Home</h1>
    <p>If you are seeing this, you are authenticated.</p>
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
