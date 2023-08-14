<template>
  <section>
    <div class="container">
      <div class="feed-list" ref="feedList">
        <post-card
          v-for="(post, index) in posts"
          :key="index"
          :postIndex="index"
          class="post-card-item"
        />
      </div>
    </div>
    <div id="arrows">
      <div class="orange-triangle"></div>
      <div class="peach-triangle"></div>
      <div class="yellow-triangle"></div>
    </div>
  </section>
</template>

<script>
import PostCard from "../components/PostCard.vue";
import { mapActions } from "vuex";

export default {
  name: "feed-list",
  data() {
    return {
      
    };
  },
  components: {
    PostCard,
  },
  computed: {
    posts() {
      return this.$store.state.posts.length > 0 ? this.$store.state.posts : {};
    },
  },
  created() {
    this.fetchPosts();
  },
  methods: {
    ...mapActions(["fetchPosts"]),
    shiftDisplay(direction) {
      const leftIndex =
        (this.displayedIndices.left - 1 + this.posts.length) %
        this.posts.length;
      const rightIndex = (this.displayedIndices.right + 1) % this.posts.length;

      if (direction === "left" && this.posts[leftIndex] !== undefined) {
        this.displayedIndices.right = this.displayedIndices.center;
        this.displayedIndices.center = this.displayedIndices.left;
        this.displayedIndices.left = leftIndex;
      } else if (
        direction === "right" &&
        this.posts[rightIndex] !== undefined
      ) {
        this.displayedIndices.left = this.displayedIndices.center;
        this.displayedIndices.center = this.displayedIndices.right;
        this.displayedIndices.right = rightIndex;
      }
    },
  },
};
</script>

<style>
.feed-list {
  width: 100%;
  display: flex;
  justify-content: space-evenly;
  flex-wrap: nowrap;
}

.post-card-item {
  margin-right: 150px; 
}

body {
  background-color: lightblue;
}

.container {
  position: relative;
  display: flex;
  justify-content: space-evenly;
  padding: 10px;
  /* overflow: hidden; */
}

.feed-list-left {
  /* margin-left: none;
  margin-right: 0px; */
}

.feed-list-right {
  /* margin-left: 250px;
  margin-right: none; */
}

/* .orange-triangle {
  width: 0; 
  height: 0; 
  position: sticky;
  border-top: 300px solid #FF9B42;
  border-bottom: 300px solid #FF9B42; 
  border-left: 200px solid transparent; 
  border-right: 200px solid #FF9B42;
  transform: translateX(1600px);
  margin-top: -520px;
}

.peach-triangle {
  width: 0; 
  height: 0; 
  position: sticky;
  border-top: 320px solid #F7A072;
  border-bottom: 320px solid #F7A072; 
  border-left: 220px solid transparent; 
  border-right: 220px solid #F7A072;
  transform: translateX(1600px);
  margin-top: -620px;
}

.yellow-triangle {
  width: 0; 
  height: 0; 
  position: sticky;
  border-top: 320px solid #EDDEA4;
  border-bottom: 320px solid #EDDEA4; 
  border-left: 220px solid transparent; 
  border-right: 220px solid #EDDEA4;
  transform: translateX(1620px);
  margin-top: -640px;
} */
</style>