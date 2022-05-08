<template>
  <div class="container">
    <button @click="btnClick">{{btnText}}</button>
  </div>
</template>

<script>
export default {
  name: "ButtonComponent",
  props: {
    btnText: {
      type: String
    }
  },
  methods: {
    btnClick() {
      this.$emit("btn-click");
    }
  }
}
</script>

<style scoped>


button {
  width: 200px;
  background-image: linear-gradient(#838A7C, #55E86E);
  border: none;
  border-radius: 8px;
  height: 45px;
  color: white;
}

button:hover {
  background-color: white;
  background: white;
  border: 2px solid green;
  cursor: pointer;
  color: green;
}
</style>