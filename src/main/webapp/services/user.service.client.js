function UserService() {
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/tsnaik/users/';
    //DELETE - Delete
    let deleteUser = (id) => fetch(`${this.url}${id}/`, {
        method: 'DELETE'
    }).then((response) => response.json());

    let findUserById = (id) => fetch(`${this.url}${id}/`, {
        method: 'GET'
    }).then((response) => response.json());

    // POST - Create
    let createUser = (user) => fetch(this.url, {
        method: 'POST',
        body: JSON.stringify(user),
        headers: {
            'content-type': 'application/json'
        }
    }).then((response) => response.json());

    // GET - Read
    let findAllUsers = () => fetch(this.url).then((response) => response.json());

    this.findAllUsers = findAllUsers;
    this.createUser = createUser;
    this.deleteUser = deleteUser;
    this.findUserById = findUserById;
}
