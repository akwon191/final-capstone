<template>
  <div class="upload">
    <div class="card-border-1"></div>
    <div class="card-border-2"></div>
    <div class="card-border-3"></div>
    <h2>Upload a Photo</h2>
    <div>
      <input
        type="file"
        id="fileInput"
        ref="fileInput"
        @change="onFileSelected"
      />
    </div>
    <ul id = "preview"></ul>
    <div>
      <button @click="$refs.fileInput.click()">Pick an Image</button>
    </div>
    <div>
      <textarea v-model="caption" type="text" id="caption" rows = "10" cols = "40" wrap = "soft" placeholder = "Insert Caption Here"></textarea>
    </div>
    <div>
      <button @click="onUpload" class="upload-button">Upload</button>
    </div>
  </div>
</template>

<script>

import { mapState } from "vuex";
import ImageService from '../services/ImageService';
import PostService from '../services/PostService';


export default {
  name: "Upload",
  data() {
    return {
      selectedFile: null,
      caption: "",
    };
  },
  computed: {
    ...mapState(["user"]),
    userId() {
      return this.user.id || null;
    },
  },
  methods: {
    onFileSelected(evt) {
      this.selectedFile = evt.target.files[0];
      this.previewFile();
    },
    onUpload() {
      if (!this.selectedFile || !this.caption) {
        alert("Please select an image and enter a caption.");
        return;
      }
      try {
        const formdata = new FormData();
        formdata.append("file", this.selectedFile);
      
        ImageService.postImage(formdata).then((response) => {
            const image_data_id = response.data.imageId;

            const post = {
              userId: this.userId,
              caption: this.caption,
              imgId: image_data_id,
            };

            PostService.addPost(post)
              .then((postResponse) => {
                alert("Post uploaded!", postResponse.data);
              })
              .catch((error) => {
                console.error("Error uploading post:", error);
              });

            this.selectedFile = null;
            this.caption = "";
            this.$router.push('/');
          })
      } catch (error) {
        console.error("Error uploading photo:", error);
      }
    },
    previewFile() {
      let preview = document.getElementById("preview");
      let fileInput = document.getElementById("fileInput");

      if (fileInput != null) {
        for (let i = 0; i < fileInput.files.length; i++) {
          let reader = new FileReader();
          reader.onload = function (readerEvent) {
            let listItem = document.createElement("li");
            listItem.innerHTML =
              "<img src='" + readerEvent.target.result + "' />"; // creates img tag for display
            preview.append(listItem); // adds img to preview list
          };

          reader.readAsDataURL(fileInput.files[i]);
        }
      }
    },
  },
};
</script>

<style>
.upload {
  text-align: center;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-self: center;
  position: relative;
  width: 500px;
  height: 600px;
  background: whitesmoke;
  margin-left: 500px;
  margin-top: 100px;
  align-items: center;
  margin: 0 auto;
  margin-top: 80px;
  box-sizing: border-box; 
  padding: 0px;
}

#fileInput {
  display: none;
}

.upload-button {
  background-color: whitesmoke;
  border: 2px solid #ff5765;
  border-radius: 15px;
  font-family: courgette;
  color: #365016;
  padding: 10px 20px;
  font-size: 1rem;
  cursor: pointer;
  transition: background-color 0.3s, color 0.3s, border-color 0.3s;
  margin-left: 10px;
  margin-top: none;
  display: block;
}

.upload-button:hover {
background-color: #ff5765;
color: #365016;
}

h2 {
  font-family: "Courgette";
  font-size: 2.5rem;
  color: #365016;
  margin-top: -30px;
  text-shadow: 0px 0px 1px black;
}

#caption {
  margin-top: 50px;
}

ul {
  text-align: center;
}

li {
  list-style: none;
}

li img {
  width: 220px;
  height: 180px;
  margin-right: 35px;
}





</style>