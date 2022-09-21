<template>
    <div class="container"> 
        <h1 class="text-center">Persons</h1>
        <table class="table table-striped">
            <thead>
                <th>Person Name</th>
                <th>Person Age</th>
            </thead>
            <tbody>
                <tr v-for = "(person, index) in personsList" v-bind:key = "person.name">
                    <td>{{person.name}}</td>
                    <td>{{person.age}}</td>
                    <td><button @click="editPerson(index)" class="btn rounded-0">Edit</button></td>
                    <td><button @click="removePerson(index)" class="btn rounded-0">Delete</button></td>
                </tr>
            </tbody>
        </table>
        <div>
            <form>
                <div>
                    <label for="name"></label>
                    <input v-model="personName" type="text" placeholder="Name">
                    
                    
                    <label for="age"></label>
                    <input v-model="personAge" type="text" placeholder="Age">

                    
                </div>                    
            </form>
            <button @click="addPerson" class="btn rounded-0">Add</button>
        </div>
    </div>
</template>

<script>
import PersonServices from '../services/PersonServices';

    export default {
        name: 'PersonsList',
        data(){
            return {
                personsList : [],
                personName: '',
                personAge: '',
                getPersons(){
                PersonServices.getPersons().then((response) => {
                    this.personsList = response.data;
                })
            },
            }
            
        },
        methods: {
            addPerson: function(){
                this.personsList.push({
                    name: this.personName,
                    age: this.personAge
                })
                             
            },
            removePerson: function(index){
                this.personsList.splice(index, 1)
            },
            editPerson: function(index){
                this.personsList.splice(index, 1, {name:this.personName, age:this.personAge})
                /*this.personsList.push({
                    name: this.personName,
                    age: this.personAge
                })*/
            }

        },

        created() {
            this.getPersons();
            this.addPerson();
        }
    }


/*import axios from 'axios'

    export default {
        name:'PersonsList',
        data() {
            return {
                personsList: [],
            }
        },
        methods: {
            getPersons(){
                axios.get('http://localhost:8080/api/v1/persons')
                    .then((response) => {
                        this.personsList = response.data
                        console.log(response.data)
                    })
                    .catch((error) => {
                        console.log(error)
                    })
            }
        },
        create(){
            this.getPersons()
        }
    }*/
</script>

<style>
    *{
      font-family: Avenir, Helvetica, Arial, sans-serif;
      -webkit-font-smoothing: antialiased;
      -moz-osx-font-smoothing: grayscale;
      text-align: center;
      color: #2c3e50;
      margin-top: 60px;
    }
    </style>

