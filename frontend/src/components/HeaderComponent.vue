<template>
  <nav>
    <div class="header-container">
      <div class="toplinks">
        <router-link to="/">Home</router-link> |
        <router-link to="/about">About</router-link> |
        <router-link to="/contact">Contact</router-link>
      </div>
    </div>
  </nav>

</template>

<script>
export default {
  name: 'HeaderComponent',
  props: {
    msg: String
  }
}
</script>

<style scoped>

.header-container {
  margin-top: 5rem;

  border-bottom: 2px solid green;
}

.toplinks {
  margin-bottom: 1rem;
}
nav a.router-link-exact-active {
  text-decoration: underline;
  font-weight: bold;
  color: green;
}

nav a {
  text-decoration: none;
  color: inherit;
}

</style>
