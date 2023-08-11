<template>
    <section>
      <div class = "container">
        <div class="feed-list-left">
          <post-card />
        </div>
        <div class="feed-list">
          <post-card />
        </div>
        <div class="feed-list-right">
          <post-card />
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

.orange-triangle {
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
}


</style>