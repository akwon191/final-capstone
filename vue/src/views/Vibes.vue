<template>
  <div id="fav-main">
      <post-card
        v-bind:key="post.postId"
        v-bind:post="post"
        v-for="post in $store.state.posts"
      />
    </div>
</template>

<script>
import PostCard from "../components/PostCard.vue";
import PostService from "../services/PostService.js";
export default {
      name: "home",
      created() {
       PostService.listVibes().then((response) => {
        this.$store.commit("setPosts", response.data);
      })
      .catch((error) => {
        if (error.response.status == 404) {
          this.$router.push("/not-found");
        }
        console.log(error);
      });
  },
  components: { PostCard },
};

</script>

<style>

</style>