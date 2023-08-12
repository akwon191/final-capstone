<script src="https://cdnjs.cloudflare.com/ajax/libs/vue/2.5.17/vue.js"></script>
<template>
  <div id="main">
    <div id="main-card">
      <div class="card-border-1"></div>
      <div class="card-border-2"></div>
      <div class="card-border-3"></div>
      <div id="image-container">
        <img id="post-img" :src="imageUrl" alt="Image" />
      </div>
      <div class="post-content">
        <h2 id="post-author">{{ postList[postIndex].username }}</h2>
        <p id="description">{{ postList[postIndex].caption }}</p>
      </div>
      <div id="button-container">
        <div id="button-vibes">
          <div class="button-style" @click="setVibes()" v-show="!vibeCheck">
            <i
              class="fa-solid fa-hand-holding-heart"
              style="color: #57614b"
            ></i>
          </div>
          <div class="button-style" @click="setVibes()" v-show="vibeCheck">
            <i
              class="fa-solid fa-hand-holding-heart"
              style="color: #c52e1d"
            ></i>
          </div>
        </div>
        <div id="button-thanks">
          <div class="button-style" @click="setThanks()" v-show="!thanksCheck">
            <i class="fa-solid fa-thumbs-up" style="color: #57614b"></i>
          </div>
          <div class="button-style" @click="setThanks()" v-show="thanksCheck">
            <i class="fa-solid fa-thumbs-up" style="color: #c52e1d"></i>
          </div>
        </div>
        <div id="button-nothanks">
          <div
            class="button-style"
            @click="setNoThanks()"
            v-show="!noThanksCheck"
          >
            <i class="fa-solid fa-thumbs-down" style="color: #57614b"></i>
          </div>
          <div
            class="button-style"
            @click="setNoThanks()"
            v-show="noThanksCheck"
          >
            <i class="fa-solid fa-thumbs-down" style="color: #c52e1d"></i>
          </div>
        </div>
        <div class="button-style" @click="toggleHidden">
          <i class="fa-solid fa-comment" style="color: #57614b"></i>
        </div>
        <div class="button-style">
          <button class="fa-solid fa-ellipsis" style="color: #57614b"></button>
        </div>
      </div>
    </div>
    <transition name="expand">
      <div id="comments-card" v-show="isHidden">
        <h1 id="comments-title">Comments</h1>
        <div class="comment" v-if="this.$store.state.posts.length > 0">
          <div
            id="single-comment"
            v-for="(comment, commentIndex) in postList[postIndex].comments"
            :key="commentIndex"
          >
            <h4 id="comment-author">{{ comment.commentId }}</h4>
            <p id="comment-text">{{ comment.commentText }}</p>
          </div>
        </div>
      </div>
    </transition>
    <transition name="expand">
      <div class="card-border-1 comments-border" v-show="isHidden"></div>
    </transition>
    <transition name="expand">
      <div class="card-border-2 comments-border" v-show="isHidden"></div>
    </transition>
    <transition name="expand">
      <div class="card-border-3 comments-border" v-show="isHidden"></div>
    </transition>
  </div>
</template>
  
<script>
import axios from "axios";

export default {
  name: "post-card",
  data() {
    return {
      isHidden: false,
      vibeCheck: false,
      thanksCheck: false,
      noThanksCheck: false,
      isLoadingImage: true,
      imageUrl: '',
    };
  },
  props: {
    postIndex: Number, // Prop to receive the index number
  },
  created() {
      this.fetchImage(this.postList[this.postIndex].img_id);
  },
  computed: {
    postList() {
      return this.$store.state.posts.length > 0 ? this.$store.state.posts : {};
    },
    // imageUrl() {
    //   if (this.postList && this.postList > 0) {
    //     return this.fetchImage(this.postList[this.postIndex].imageId);
    //   }
    // },
  },
  methods: {
    setVibes() {
      this.vibeCheck = !this.vibeCheck;
    },
    setThanks() {
      this.thanksCheck = !this.thanksCheck;
    },
    setNoThanks() {
      this.noThanksCheck = !this.noThanksCheck;
    },
    toggleHidden() {
      this.isHidden = !this.isHidden;
    },
    fetchImage(imageId) {
      axios
        .get(`http://localhost:9000/images/${imageId}`)
        .then((response) => {
          this.imageUrl = `data:image/jpg;base64,${response.data.imageData}`;
        })
        .catch((error) => {
          console.error("Image could not be retrieved:", error);
        })
        .finally(() => {
          this.isLoadingImage = false; // Set isLoadingImage to false when done
        });
    },
  },
};
</script>
  
<style>
@import url("https://fonts.googleapis.com/css2?family=Courgette&family=Lobster&display=swap");

html {
  overflow-y: scroll;
}

#main {
  display: flex;
  flex-direction: column;
}

#main-card {
  margin-top: 80px;
  position: relative;
  width: 500px;
  height: 600px;
  background: whitesmoke;
}

.card-border-1 {
  pointer-events: none;
  position: absolute;
  top: -10px;
  left: -10px;
  border: 10px solid #e85e6a;
  border-radius: 10px;
  width: 500px;
  height: 600px;
  z-index: -1;
}

.card-border-2 {
  pointer-events: none;
  position: absolute;
  top: -20px;
  left: -20px;
  border: 20px solid #ea70cf;
  border-radius: 10px;
  width: 500px;
  height: 600px;
  z-index: -2;
}

.card-border-3 {
  pointer-events: none;
  position: absolute;
  top: -30px;
  left: -30px;
  border: 30px solid #ffba29;
  border-radius: 10px;
  width: 500px;
  height: 600px;
  z-index: -3;
  box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}

.comments-border {
  margin-top: 690px;
  margin-left: 702px;
}

#post-title {
  font-family: "Courgette";
  font-size: 2rem;
  color: #365016;
  margin: 20px;
  text-shadow: 0px 0px 1px black;
}

#post-author {
  font-family: "Courgette";
  font-size: 1.5rem;
  color: #365016;
  margin: 20px;
  text-shadow: 0px 0px 1px black;
}

#description {
  font-family: "Courgette";
  font-size: 1rem;
  color: #365016;
  margin: 20px;
}

#image-container {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 10px auto; /* Adjust margin as needed */
}

#post-img {
  max-width: 100%;
  max-height: 300px; /* Adjust height as needed */
  min-height: 300px;
  object-fit: contain; /* or "cover" depending on design */
}

#button-container {
  display: flex;
  justify-content: space-evenly;
  font-size: 2rem;
}

.button-style {
  height: 50px;
  width: 50px;
  display: flex;
  justify-content: center;
  align-items: center;
  border: 1px solid #365016;
  border-radius: 15px;
  box-shadow: rgba(54, 80, 22, 0.17) 0px -23px 25px 0px inset,
    rgba(54, 80, 22, 0.15) 0px -36px 30px 0px inset,
    rgba(54, 80, 22, 0.1) 0px -79px 40px 0px inset,
    rgba(54, 80, 22, 0.06) 0px 2px 1px, rgba(54, 80, 22, 0.09) 0px 4px 2px,
    rgba(54, 80, 22, 0.09) 0px 8px 4px, rgba(54, 80, 22, 0.09) 0px 16px 8px,
    rgba(54, 80, 22, 0.09) 0px 32px 16px;
}

#comments-card {
  position: relative;
  width: 500px;
  height: 600px;
  background: whitesmoke;
}

#comments-title {
  border-top: 5px solid #e85e6a;
  border-bottom: 5px solid #e85e6a;
  font-family: "Courgette";
  font-size: 1.5rem;
  color: #365016;
  text-align: center;
  margin: auto;
}

.comment {
  border: solid 1px rgba(0, 0, 0, 0.5);
  border-radius: 10px;
  margin: 10px;
  box-sizing: border-box;
  width: auto;
  position: relative;
  clear: both;
  background: rgb(226, 226, 226);
  transition: opacity 0.5s;
}

#comment-author {
  font-family: "Courgette";
  font-size: 1rem;
  color: #365016;
  margin: 10px;
}

#comment-text {
  font-family: "Courgette";
  font-size: 0.9rem;
  color: #365016;
  margin: 10px;
}

.expand-enter-active,
.expand-leave-active {
  transition: all 1s ease;
  max-height: 1000px;
}

.expand-enter,
.expand-leave-to {
  max-height: 0px;
  overflow: hidden;
}
</style>