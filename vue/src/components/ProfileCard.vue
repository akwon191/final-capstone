<template>
    <div id="profile-card">
        <div class="card-border-1"></div>
        <div class="card-border-2"></div>
        <div class="card-border-3"></div>
        <div id = "profile-info">
            <h2 id="profile-author">{{ profile.username }}</h2>
            <p id = "profile-description">{{ profile.description}}</p>
        </div>
        <div id="posts-follow">
            <ul>
                <li id="posts-number">
                {{ profile.postCount }} Posts
                </li>
                <li id="followers-number">
                {{ profile.followerCount }} Followers
                </li>
                <li id="following-number">
                {{ profile.followingCount }} Following
                </li>
            </ul>
        </div>
    </div>
</template>



<script>
import ProfileService from "../services/ProfileService";

export default {
    name: 'profile-card',
    created() {
        ProfileService.getProfile().then((response) => {
        this.$store.commit("SET_PROFILE", response.data);
      })
      .catch((error) => {
        console.log(error.response);
      });
    }
}

</script>

<style scoped>

#profile-card {
    display: flex;
    flex-direction: column;
}
</style>