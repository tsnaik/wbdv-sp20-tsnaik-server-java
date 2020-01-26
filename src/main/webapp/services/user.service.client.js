function UserService() {
    this.url = 'https://wbdv-generic-server.herokuapp.com/api/tsnaik/users/';

    //DELETE - Delete
    this.deleteUser = (id) => fetch(`${this.url}${id}/`, {
        method: 'DELETE'
    }).then((response) => response.json());

    this.findUserById = (id) => fetch(`${this.url}${id}/`, {
        method: 'GET'
    }).then((response) => response.json());

    this.updateUser = (id, user) => fetch(`${this.url}${id}/`, {
        method: 'PUT',
        body: JSON.stringify(user)
    }).then((response) => response.json());

    // POST - Create
    this.createUser = (user) => fetch(this.url, {
        method: 'POST',
        body: JSON.stringify(user),
        headers: {
            'content-type': 'application/json'
        }
    }).then((response) => response.json());

    // GET - Read
    this.findAllUsers = () =>
        fetch(this.url)
            .then((response) => response.json());
}
