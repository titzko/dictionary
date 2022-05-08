<template>
  <div class="page-container">
    <div class="creationResultDiv" v-show="displayCreationResult" :style="isCreationSuccess ? {'background-color': 'green'} : {'background-color': 'red'} ">
      <div>{{creationResultMessage}}</div>
      <div class="message-icon-div" v-if=isCreationSuccess ><i class="bi bi-check2"></i>
        </div>
      <div v-else class="message-icon-div">
        <i class="bi bi-x-circle-fill"></i>
      </div>
       </div>

    <h1>Welcome to my Dictionary</h1>

    <h4> For <span class="underline"> my personal</span> orientation, I created this overview over blogposts, repositories and applications.</h4>

    <div class="flex-container">
      <div v-for="(card) in myCardComponents" :key="card.id" >
        <card-component :cardData=card  @delete-card="showDeleteMessage"/>
      </div>
    </div>
    <div class="btnContainer">
      <ButtonComponent  @btn-click="showModal" btn-text="Create Card" style="float: right; margin-left: 20px"/>
    </div>
  </div>


  <ModalComponent
      v-show="isModalVisible"
      @close="closeModal"
      @show-modal-message="showSuccessMessage"
  />

</template>

<script>

import CardComponent from "@/components/CardComponent";
import ButtonComponent from "@/components/ButtonComponent";
import ModalComponent from "@/components/ModalComponent";
import { getDictEntries } from "@/services/RestDictionaryService"

export default {
  name: 'HomeView',
  components: {
    CardComponent,
    ButtonComponent,
    ModalComponent
  },
  data() {
    return {
      myCardComponents: [],
      isModalVisible: false,
      creationResultMessage: "",
      displayCreationResult: false,
      isCreationSuccess: false
    }
  },
  mounted() {
    this.getAllEntries();
  },
  methods: {
    showModal() {
      this.isModalVisible = true;
    }, showDeleteMessage(text) {
      this.showSuccessMessage(text)
    this.getAllEntries();
  },
    getAllEntries() {
      getDictEntries().then((entries) => {
        this.myCardComponents =  entries;
      })
    },
    closeModal() {
      this.isModalVisible = false;
    },showSuccessMessage(text) {
      console.log(text);
      this.creationResultMessage =text;
      this.displayCreationResult = true;
      if(text === "Entry created" || text ==="Deleted"){
        this.isCreationSuccess = true;
      }else {
        this.isCreationSuccess = false;
      }
      const myDelay = 4000;
      setTimeout(() => {
        this.displayCreationResult = false;
      }, myDelay);
      this.getAllEntries();


    },
  }
}
</script>

<style scoped>


.page-container {
  margin-top:5rem;
}
.underline {
  text-decoration: underline;
  font-weight: bold;
}

.flex-container {
  display: flex;
  flex-wrap: wrap;
}

.flex-container > div {
  background-color: #f1f1f1;
  width: 30%;
  margin: 10px;
  text-align: center;
  line-height: 75px;
  font-size: 30px;
  transition: all 0.5s ease-out;
}

.flex-container > div:hover {
  color: whitesmoke;
  background-image: linear-gradient(#838A7C, #55E86E);
}

.btnContainer {
  margin-top: 20px;
}

div.creationResultDiv {
  position: -webkit-sticky;
  position: sticky;
  top: 0;
  font-size: 20px;
  color: whitesmoke;
  flex-direction: row;
  flex-wrap: wrap;
  display: flex;
  justify-content: space-between;
  height: 35px;
  opacity: 50%;

}


.message-icon-div {
  float: right;
  margin-right: 1rem;
}

</style>
