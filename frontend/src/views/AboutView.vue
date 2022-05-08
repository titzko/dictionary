<template>
  <div class="page-container">
    <h1>About me</h1>
    <br>
    <h4>Here is some random text noone cares about. Here is some random text noone cares aboutHere is some random text noone cares about</h4>
    <div class="main-container">
      <div class="left-container">Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.</div>
      <div class="right-container">
        <img src="../assets/avatar.png">
      </div>
    </div>
    <div class="bottom-container">
      Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet. Lorem ipsum dolor sit amet, consetetur sadipscing elitr, sed diam nonumy eirmod tempor invidunt ut labore et dolore magna aliquyam erat, sed diam voluptua. At vero eos et accusam et justo duo dolores et ea rebum. Stet clita kasd gubergren, no sea takimata sanctus est Lorem ipsum dolor sit amet.
    </div>
  </div>


</template>

<script>
export default {
  name: 'AboutView'
}
</script>

<style scoped>

img {
  max-width: 100%;
  min-height: 250px;
  max-height: 400px;
  display: block;
  margin-left: 7%;
}

.page-container {
  margin-top:5rem;
}

@media screen and (max-width: 700px) {
  .main-container {
    display: flex;
    width: 100%;
    height: 600px;
    border-top: 1px solid
  }
}

@media screen and (min-width: 700px) {
  .main-container {
    display: flex;
    width: 100%;
    height: 400px;
  }
}

.left-container {
  flex: 0 1 50%;
  max-width: 50%;
  height: 100%;
  min-height: 100%;
}

.right-container {
  flex: 0 1 50%;
  display: flex;
  min-height: 400px;
  max-height: 400px;

  max-width: 50%;
  flex-wrap: wrap;
  align-items: flex-start;
}

@media screen and (min-width: 900px) {
  .bottom-container {
    margin-top: 5rem;
  }
}
</style>
