import axios from 'axios'

const API_URL = "http://localhost:8080/api/v1/persons";

class PersonServices {
    getPersons(){
        return axios.get(API_URL);
        
    }
    addPerson(person){
        return axios.post(API_URL, person);
    }
}

export default new PersonServices()



