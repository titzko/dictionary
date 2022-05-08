<template>
  <transition name="modal-fade">
    <div class="modal-backdrop">
      <div class="modal" role="dialog" aria-labelledby="modalTitle" aria-describedby="modalDescription">
        <header class="modal-header" id="modalTitle">
          <slot name="header">
            Create new entry:
          </slot>
          <button type="button" class="btn-close" @click="close" aria-label="Close modal">
            x
          </button>
        </header>
        <section class="modal-body" id="modalDescription">
          <div class="input-container">
            <label for="descriptionID">Description *</label>
            <input type="text" id="descriptionID" placeholder="Description of resource.." />
            <label for="frameworksID">Frameworks</label>
            <input type="text" id="frameworksID" placeholder="Frameworks.." />
            <label for="giturlID">Git-URL</label>
            <input type="text" id="giturlID" placeholder="Git-URL.." />
            <label for="blogpageurlID">Blogpage-URL</label>
            <input type="text" id="blogpageurlID" placeholder="Blogpage-URL.." />
            <label for="exampleURLID">Example-URL</label>
            <input type="text" id="exampleURLID" placeholder="Example-URL.." />
          </div>
        </section>
        <footer class="modal-footer">
          <button type="button" class="btn-bottom" @click="createCard" aria-label="Close modal">
            Create
          </button>
        </footer>
      </div>
    </div>
  </transition>
</template>
<script>
import { createDictEntry } from "@/services/RestDictionaryService"

export default {
  name: "ModalComponent",
  methods: {
    close() {
      this.$emit("close");
    },createCard(){
      const description =document.getElementById("descriptionID").value;
      const frameworks =document.getElementById("frameworksID").value.split(' ');
      const giturl =document.getElementById("giturlID").value;
      const blogpageurl =document.getElementById("blogpageurlID").value;
      const exampleurl =document.getElementById("exampleURLID").value;
      const entry = {"description":description, "frameworks": frameworks, "gitlink":giturl, "exampleLink":exampleurl, "blogPostLink":blogpageurl}

      createDictEntry(entry
      ).then((text) => {
         this.$emit("show-modal-message", text);
       })
      this.$emit("close");
      document.getElementById("descriptionID").value = "";
      document.getElementById("frameworksID").value = "";
      document.getElementById("giturlID").value = "";
      document.getElementById("blogpageurlID").value = "";
      document.getElementById("exampleURLID").value = "";

    }
  },
};
</script>
<style scoped>
.modal-backdrop {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  background-color: rgba(0, 0, 0, 0.3);
  display: flex;
  justify-content: center;
  align-items: center;
}

label {
  width: 100px;
}
.modal {
  box-shadow: 2px 2px 20px 1px;
  overflow-x: auto;
  display: flex;
  flex-direction: column;
  width: 70%;
  height: 75%;
  border: 1px solid green;
  background-color: #f2f2f2;;

}
.modal-header {
  padding: 15px;
  display: flex;
}
.modal-footer {
  padding: 15px;
  display: flex;
  margin-top: auto;
  flex-direction: column;
  justify-content: center;
}
.modal-header {
  position: relative;
  border-bottom: 1px solid #eeeeee;
  color: green;
  justify-content: space-between;
}

.btn-bottom {
  width: 100%;
  background-image: linear-gradient(#838a7c, #55e86e);
  border: none;
  border-radius: 8px;
  height: 45px;
  color: white;
}

.btn-bottom:hover {
  background-color: white;
  background: white;
  border: 2px solid green;
  cursor: pointer;
  color: green;
}

.modal-body {
  position: relative;
  padding: 20px 10px;
  background-color: #f2f2f2;;
}
.btn-close {
  position: absolute;
  top: 0;
  right: 0;
  border: none;
  font-size: 20px;
  padding: 10px;
  cursor: pointer;
  font-weight: bold;
  color: green;
  background: transparent;
}

.modal-fade-enter,
.modal-fade-leave-to {
  opacity: 0;
}
.modal-fade-enter-active,
.modal-fade-leave-active {
  transition: opacity 0.5s ease;
}

input[type="text"],
select {
  width: 100%;
  padding: 12px 20px;
  margin: 8px 0;
  display: inline-block;
  border: 1px solid #ccc;
  border-radius: 4px;
  box-sizing: border-box;
}

input[type="submit"] {
  width: 100%;
  background-color: #4caf50;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  border-radius: 4px;
  cursor: pointer;
}

input[type="submit"]:hover {
  background-color: #45a049;
}

.input-container {
  border-radius: 5px;
  background-color: #f2f2f2;
  padding: 20px;
}
</style>
