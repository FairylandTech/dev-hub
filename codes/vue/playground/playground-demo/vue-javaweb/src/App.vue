<!---------------------------------------------------------
@software: WebStorm
@author: Lionel Johnson
@contact: https://fairy.host
@organization: https://github.com/FairylandFuture
@datetime: 2025-08-23 21:52:54 UTC+08:00
---------------------------------------------------------->
<template>
  <div>
    <!--    <h1>{{ message }}</h1>-->
    <element-view></element-view>
  </div>
</template>

<script>

import ElementView from "@/views/element/ElementView.vue";

export default {
  components: {ElementView},
  data() {
    return {
      message: "Hello Vue"
    }
  },

  methods: {}
}

</script>

<style scoped>

</style>
