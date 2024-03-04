describe('e2e testing', () => {
  it('check title', () => {
    cy.visit('http://localhost:5173/')

    cy.get('.item-input')
    .type('todo-one')
    .should("have.value", 'todo-one');

    cy.get('.add-button')
    .click();

    // cy.get('')
  })
})