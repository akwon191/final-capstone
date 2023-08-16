<template>
  <section>
    <div class="container">
      <div id="scroller">
        <div class="feed-list" ref="feedList">
          <post-card
            v-for="(post, index) in posts"
            :key="index"
            :postIndex="index"
            class="post-card-item"
          />
        </div>
      </div>
    </div>
    <div id="scroll-buttons">
      <div type="button" id="scroll-left" @click="scrollLeft()"></div>
      <div type="button" id="scroll-right" @click="scrollRight()"></div>
    </div>
    <div id="arrows">
      <div id="red-triangle-right"></div>
      <div id="pink-triangle-right"></div>
      <div id="yellow-triangle-right"></div>
      <div id="red-triangle-left"></div>
      <div id="pink-triangle-left"></div>
      <div id="yellow-triangle-left"></div>
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
      rightScroll: false,
      leftScroll: false,
      currentPos: 1,
      x: 0,
      y: 0,
    };
  },
  components: {
    PostCard,
  },
  computed: {
    posts() {
      return this.$store.state.posts.length > 0 ? this.$store.state.posts : {};
    },
    vibes() {
      return this.$store.state.vibes.length > 0 ? this.$store.state.vibes : {};
    },
    thanks() {
      return this.$store.state.thanks.length > 0 ? this.$store.state.thanks : {};
    }
  },
  created() {
    this.fetchPosts();
    this.fetchVibes();
    this.fetchThanks();
  },
  methods: {
    ...mapActions([
      "fetchPosts",
      "fetchVibesByUserId",
      "fetchThanksByUserId", 
    ]),
    fetchVibes() {
      const userId = this.$store.state.user.id;
      this.fetchVibesByUserId(userId).catch((error) => {
        console.error("Error fetching vibes:", error);
      });
    },
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
    scrollRight() {
      if (this.currentPos < this.posts.length) {
        document
          .getElementById("scroller")
          .animate(
            [
              { transform: `translateX(${this.x}px` },
              { transform: `translateX(${this.x - 650}px` },
            ],
            {
              duration: 600,
              iterations: 1,
              fill: "forwards",
            }
          );
        this.x -= 650;
        this.currentPos += 1;
      }
    },
    scrollLeft() {
      if (this.currentPos > 1) {
        document
          .getElementById("scroller")
          .animate(
            [
              { transform: `translateX(${this.x}px` },
              { transform: `translateX(${this.x + 650}px` },
            ],
            {
              duration: 600,
              iterations: 1,
              fill: "forwards",
            }
          );
        this.x += 650;
        this.currentPos -= 1;
      }
    },
    fetchThanks() {
      const userId = this.$store.state.user.id;
      this.fetchThanksByUserId(userId).catch((error) => {
        console.error("Error fetching thanks:", error);
      });
    },
  },
};
</script>

<style>
body {
  overflow-x: hidden;
}

.feed-list {
  display: flex;
  justify-content: flex-start;
  flex-wrap: nowrap;
  position: relative;
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
}

#scroller {
  position: absolute;
  overflow: visible;
  left: 37%;
}

#scroll-buttons {
  display: flex;
  flex-direction: row;
  justify-content: space-between;
}

#scroll-left {
  width: 560px;
  height: 600px;
  position: sticky;
  margin-top: 65px;
}

#scroll-right {
  width: 560px;
  height: 600px;
  position: sticky;
  margin-top: 65px;
}

#red-triangle-right {
  pointer-events: none;
  width: 0;
  height: 0;
  position: sticky;
  border-top: 310px solid #e85e6a;
  border-bottom: 310px solid #e85e6a;
  border-left: 210px solid transparent;
  border-right: 210px solid #e85e6a;
  transform: translateX(1640px);
  margin-top: -605px;
}

#pink-triangle-right {
  pointer-events: none;
  width: 0;
  height: 0;
  position: sticky;
  border-top: 320px solid #ea70cf;
  border-bottom: 320px solid #ea70cf;
  border-left: 220px solid transparent;
  border-right: 220px solid #ea70cf;
  transform: translateX(1650px);
  margin-top: -630px;
}

#yellow-triangle-right {
  pointer-events: none;
  width: 0;
  height: 0;
  position: sticky;
  border-top: 330px solid #ffd06b;
  border-bottom: 330px solid #ffd06b;
  border-left: 230px solid transparent;
  border-right: 230px solid #ffd06b;
  transform: translateX(1660px);
  margin-top: -650px;
}

#red-triangle-left {
  pointer-events: none;
  width: 0;
  height: 0;
  position: sticky;
  border-top: 310px solid #e85e6a;
  border-bottom: 310px solid #e85e6a;
  border-right: 210px solid transparent;
  border-left: 210px solid #e85e6a;
  transform: translateX(-155px);
  margin-top: -640px;
}

#pink-triangle-left {
  pointer-events: none;
  width: 0;
  height: 0;
  position: sticky;
  border-top: 320px solid #ea70cf;
  border-bottom: 320px solid #ea70cf;
  border-right: 220px solid transparent;
  border-left: 220px solid #ea70cf;
  transform: translateX(-185px);
  margin-top: -630px;
}

#yellow-triangle-left {
  pointer-events: none;
  width: 0;
  height: 0;
  position: sticky;
  border-top: 330px solid #ffd06b;
  border-bottom: 330px solid #ffd06b;
  border-right: 230px solid transparent;
  border-left: 230px solid #ffd06b;
  transform: translateX(-215px);
  margin-top: -650px;
}
</style>