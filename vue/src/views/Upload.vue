<template>
  <div class = "upload">
      <input type = "file" class = "file-input" ref ="fileInput" @change ="onFileSelected">
      <button @click="$refs.fileInput.click()">Pick File</button>
      <button @click="onUpload" class="upload-button">Upload</button>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'Upload',
    data() {
        return {
            selectedFile: null
        }
    },
    methods: {
        onFileSelected(evt) {
            this.selectedFile = evt.target.files[0]
        },
        onUpload() {
            let formdata = new FormData();
            formdata.append('file', this.selectedFile);
            const options = {
                headers: {
                    'Content-Type': 'multipart/form-data'
                }
            }
            axios.post('http://localhost:9000/upload', formdata, options).then(response => {
                console.log(response)
            })
        }
    }
}   
</script>

<style>
.upload {
  text-align: center;
  margin-top: 100px;
}

.file-input {
  display: none;
}

.upload-button {
  background-color: #EA70CF;;
  color: white;
  padding: 10px 20px;
  border: none;
  cursor: pointer;
  transition: background-color 0.3s ease;
  margin-left: 10px;
}

.upload-button:hover {
  background-color: #FFBA29;
}
</style>