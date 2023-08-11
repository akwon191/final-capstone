<template>
    <div>
      <page-headers />
      <profile-card />
    </div>
  </template>
  
  <script>
  import PageHeaders from '../components/Headers.vue'
  import ProfileCard from '../components/ProfileCard.vue'
  
  export default {
    name: "profile",
    components: {
      PageHeaders,
      ProfileCard
    }
  };
  </script>