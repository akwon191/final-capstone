<template>
    <section>
      <!-- <div class = "container">
        <div class="feed-list-left">
          <post-card />
        </div> -->
        <div class="feed-list">
          <post-card />
        </div>
        <!-- <div class="feed-list-right">
          <post-card />
        </div>
      </div> -->
    </section>
</template>

<script>
import PostCard from '../components/PostCard.vue';

export default {
    name: 'feed-list',
    components: {
        PostCard
    }
}

</script>

<style>
.feed-list {
    display:flex;
    justify-content: space-evenly;
    flex-wrap: nowrap;
}

body {
  background-color: lightblue;
}

.container {
  position: relative;
  display: flex;
  justify-content: space-evenly;
  padding: 10px;
}

.feed-list-left {
  margin-left: none;
  margin-right: 250px;

}

.feed-list-right {
  margin-left: 250px;
  margin-right: none;
}
</style>