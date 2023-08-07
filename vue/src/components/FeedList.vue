<template>
    <section>
      <div class="feed-list">
        <post-card />
      </div>
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
</style>