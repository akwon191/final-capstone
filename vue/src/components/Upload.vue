<template>
  <div class = "upload">
      <input type = "file" ref ="fileInput" @change ="onFileSelected">
      <button @click="$refs.fileInput.click()">Pick File</button>
      <button @click="onUpload">Upload</button>
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

</style>