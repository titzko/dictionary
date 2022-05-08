<template>
  <div class="container">
    <div class="card-description" >{{cardData.description}}</div>
    <ul v-for="(framework, index) in cardData.frameworks" :key="index">
      <li> <span>{{ framework }} </span></li>
    </ul>
    <div class="icon-container">
     <a :href="[!cardData.gitlink ? '#': cardData.gitlink]"> <span :class="[!cardData.gitlink ? 'icon-disabled': 'icon-enabeld']"><i class="bi bi-github"></i></span></a>
      <a :href="[!cardData.blogPostLink ? '#': cardData.blogPostLink]"><span :class="[!cardData.blogPostLink  ? 'icon-disabled': 'icon-enabeld']"> <i class="bi bi-book"></i></span></a>
     <a :href="[!cardData.exampleLink ? '#': cardData.exampleLink]"><span :class="[!cardData.exampleLink  ? 'icon-disabled': 'icon-enabeld']"> <i class="bi bi-eye"></i></span></a>
      <a href="#"><span class="icon-delete" id="deleteicon"> <i class="bi bi-trash" @click="deleteEntry"></i></span></a>
    </div>
  </div>
</template>

<script>
import { deleteDictEntry } from "@/services/RestDictionaryService"

export default {
  name: "CardComponent",
  props: {
    cardData: {
      type: Object
    }
  },methods: {
    deleteEntry(){
      deleteDictEntry(this.cardData.id)
          .then((text) => {
            this.$emit("delete-card", text);
          });
    }
  }
}
</script>

<style scoped>

@media screen
and (min-width: 601px)
and (max-width: 3000px){
  .container {
    height: 250px;
    position: relative;
  }
}

@media screen
and (max-width: 600px)
and (min-width: 1px)
{
  .container {
    height: 400px;
    position: relative;
  }
}

li {
  font-size: 15px;
  left: -10px;
  text-align: left;
}

ul {
  line-height: 0.001rem;
}

.icon-container {
  position:absolute;
  bottom:0;
  right:+15px;
}

 i {
  margin-left: 10px;
}

.card-description {
  line-height: 120%;
  border-bottom: 2px solid green;
  height: 80px;
}

a {
  color: inherit;
}

.icon-disabled {
  opacity: 0.6;
  pointer-events: none;
  color:grey;
}

.delete-icon:hover {
  cursor: pointer
}

.icon-enabeld {
  color: green;
}
.container:hover .icon-delete {
  color: red;
}

.container:hover .icon-enabeld {
  color: white;
}

.icon-delete {
  opacity: 0.6;
}
</style>