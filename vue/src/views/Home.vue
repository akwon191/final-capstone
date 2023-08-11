<template>
  <div>
    <page-headers />
    <feed-list />
  </div>
</template>

<script>
import FeedList from '../components/FeedList.vue';
import PageHeaders from '../components/Headers.vue'

export default {
  name: "home",
  components: {
    FeedList,
    PageHeaders
  }
};
</script>