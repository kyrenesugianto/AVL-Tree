# AVL-Tree

In this project, the focus was on understanding AVL trees, a form of self-balancing binary search tree. The goal was to demonstrate comprehension of AVL tree concepts, make informed decisions on iterative or recursive methods, and enhance debugging and testing skills.

The project structure consisted of essential folders: src (containing submitted code), support (housing crucial support code), and test (reserved for additional tests). The core implementation occurred in the AVLTree class, emphasizing adherence to the Binary Search Tree (BST) rule.

The tasks and TODOs were organized as follows:

Task 1: Review the starter code
A thorough review of the provided code, including BSTNode, AVLTree, BSTNodeInterface, and BSTInterface, was undertaken. Assumptions for BSTs were made to ensure compliance with the BST rule.

Task 2: Complete updateHeight and balanceFactor
Two key helper methods, updateHeight and balanceFactor, were implemented to facilitate AVL tree functionality. The updateHeight method focused on adjusting node heights to maintain balance, while the balanceFactor method computed the balance factor.

Task 3: Implement rotateLeft and rotateRight
The implementation of two rotation methods, rotateLeft and rotateRight, was carried out to perform local rearrangements of the AVL tree. These rotations were essential for maintaining the BST ordering property while achieving rebalancing.

Task 4: Implement add method
The add method was implemented to preserve the AVL tree's balance. The algorithm involved standard BST insertion, updating the height and balance factor of nodes along the path, and applying rotations when the balance factor indicated imbalance.

Testing played a critical role, and additional tests were created to cover various scenarios in each method. The provided tests were considered a minimal set, and efforts were made to address potential edge cases.

In summary, this project involved a comprehensive exploration of AVL trees, encompassing practical implementation, iterative coding, debugging, and meticulous testing to ensure the robustness of the AVL tree structure.
