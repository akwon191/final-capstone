<template>
  <div class = "upload">
      <div class="card-border-1"></div>
      <div class="card-border-2"></div>
      <div class="card-border-3"></div>
      <h2>Upload a Photo</h2>
      <div>
        <input type = "file" class = "file-input" ref ="fileInput" @change ="onFileSelected">
      </div>
      <div>
        <button @click="$refs.fileInput.click()">Pick File</button>
      </div>
      <div>
        <label for="caption">Caption:</label>
        <input v-model="caption" type="text" id="caption" />
      </div>
      <div>
        <button @click="onUpload" class="upload-button">Upload</button>
      </div>
  </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'Upload',
    data() {
        return {
            selectedFile: null,
            caption: '',
        };
    },
    methods: {
        onFileSelected(evt) {
            this.selectedFile = evt.target.files[0]
        },
        onUpload() {
            if (!this.selectedFile || !this.caption) {
            alert('Please select an image and enter a caption.');
            }

            try {
                let formdata = new FormData();
                formdata.append('file', this.selectedFile);
                formdata.append('caption', this.caption);

                const options = {
                    headers: {
                        'Content-Type': 'multipart/form-data'
                    }
                }
                axios.post('http://localhost:9000/images/upload', formdata, options).then(response => {
                    console.log('Photo uploaded:', response.data)
                });
                this.selectedFile = null;
                this.caption = '';
            } catch (error) {
                console.error('Error uploading photo:', error);
            }
                
        }
    }
} 
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
  margin-top: 50px;
}

.upload-button:hover {
  background-color: #FFBA29;
}
h2 {
  font-family: 'Courgette';
  font-size: 2.5rem;
  color: #365016;
  margin: 50px;
  text-shadow: 0px 0px 1px black;
}

#caption {
  margin-top: 50px;
}
</style>