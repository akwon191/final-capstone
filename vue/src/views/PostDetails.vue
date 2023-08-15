<template>
    <div id="main">
        <div id="post-detail-card">
            <div id="detail-border-1"></div>
            <div id="detail-border-2"></div>
            <div id="detail-border-3"></div>
            <div id="content">
                <div id="full-image">
                    <img id="post-img" :src="imageUrl" alt="Image" />
                </div>
                <h1 id="post-author">Author</h1>
                <div id="full-comments">
                    <h1 id="comments-title">Comments</h1>
                </div>
            </div>
        </div>
    </div>
</template>
  
<script>
  
export default {
    name: "post-details",
};

</script>

<style>

#main {
  display: flex;
  align-items: center;
}

#post-detail-card {
  position: relative;
  width: 1000px;
  height: fit-content;
  background: whitesmoke;
}

#detail-border-1 {
  pointer-events: none;
  position: absolute;
  top: -10px;
  left: -10px;
  border-right: 10px solid #e85e6a;
  border-left: 10px solid #e85e6a;
  width: 1000px;
  height: 100%;
  z-index: -1;
}

#detail-border-2 {
  pointer-events: none;
  position: absolute;
  top: -20px;
  left: -20px;
  border-right: 20px solid #ea70cf;
  border-left: 20px solid #ea70cf;
  width: 1000px;
  height: 100%;
  z-index: -2;
}

#detail-border-3 {
  pointer-events: none;
  position: absolute;
  top: -30px;
  left: -30px;
  border-right: 30px solid #ffba29;
  border-left: 30px solid #ffba29;
  width: 1000px;
  height: 100%;
  z-index: -3;
  box-shadow: rgba(0, 0, 0, 0.24) 0px 3px 8px;
}

#full-image {
  display: flex;
  justify-content: center;
  align-items: center;
  margin: 10px auto; 
}

</style>

