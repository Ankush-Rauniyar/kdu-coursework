describe('e2e testing', () => {
  it('check title', () => {
    cy.visit('http://localhost:5173/')

    cy.get('[data-testid="title-todo"]')
    .should("exist")
    .should("have.text","Item Lister");
  })
  it('check search', () => {
    cy.visit('http://localhost:5173/')

    cy.get('.search-input')
    .type('Test Search')
    .should('have.value', 'Test Search');
  })
})