<template>
  <div id="app">
    <div id="nav">
      <page-headers />
    </div>
    <router-view />
  </div>
</template>

<script>
import PageHeaders from './components/Headers.vue'

export default {
  name: "home",
  components: {
    PageHeaders
  }
};
</script>