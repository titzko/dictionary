<template>
  <HeaderComponent msg="kekw"/>
  <router-view />
</template>

<script>
import HeaderComponent from './components/HeaderComponent.vue'

export default {
  name: 'App',
  components: {
    HeaderComponent
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  margin: 0;
  padding: 0;
  color: 	#606060;
  margin-left: 3rem;
  margin-right: 3rem;
  margin-bottom: 3rem;
}
</style>
