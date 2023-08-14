<template>
  <section>
    <div class="container">
      <div id="scroller" >
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
    scrollRight() {
      if (this.currentPos < this.posts.length) {
        document.getElementById('scroller').animate([ { transform: `translateX(${this.x}px` }, { transform: `translateX(${this.x-650}px` }
        ], {
          duration: 1000,
          iterations: 1,
          fill: 'forwards'
        });
        this.x -= 650;
        this.currentPos += 1;
      }
    },
    scrollLeft() {
      if (this.currentPos > 1) {
        document.getElementById('scroller').animate([ { transform: `translateX(${this.x}px` }, { transform: `translateX(${this.x+650}px` }
        ], {
          duration: 1000,
          iterations: 1,
          fill: 'forwards'
        });
        this.x += 650;
        this.currentPos -= 1;
      }
    }
  }
}

</script>

<style>

/* the left command does not perfectly align the first post center but it works for now while I try to animate the scroll */
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


/* .feed-list-left {
  margin-left: none;
  margin-right: 0px;
}

.feed-list-right {
  margin-left: 250px;
  margin-right: none;
} */

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