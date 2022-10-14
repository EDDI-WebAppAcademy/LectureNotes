<template>
  <div>
    <v-container>
      <h3>Vue 파일 업로드</h3>
      <div>
        <label>Files
          <input type="file" id="files" ref="files"
                 multiple v-on:change="handleFileUpload"/>
        </label>

        <button @click="submitFiles">파일 업로드</button>
      </div>
      <div>
        <label>Files
          <input type="file" id="files2" ref="files2"
                 multiple v-on:change="handleFileUpload2"/>
        </label>

        <button @click="submitFiles2">파일 + 문자열</button>
      </div>
    </v-container>
  </div>
</template>

<script>

import axios from 'axios'

export default {
  name: "FileUploadView",
  data () {
    return {
      files: '',
      response: '',
      address: new String('새말로 8길 26'),
      files2: '',
    }
  },
  methods: {
    handleFileUpload () {
      this.files = this.$refs.files.files
    },
    submitFiles () {
      let formData = new FormData()

      for (let idx = 0; idx < this.files.length; idx++) {
        formData.append('fileList', this.files[idx])
      }

      axios.post('http://localhost:7777/56th/file/uploadImgs', formData, {
        headers: {
          'Content-Type': 'multipart/form-data'
        }
      })
      .then (res => {
        alert('처리 결과: ' + res.data)
      })
      .catch(res => {
        alert('처리 결과: ' + res.message)
      })
    }
  }
}
</script>

<style scoped>

</style>